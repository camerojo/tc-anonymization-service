package org.tctalent.anonymization.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.List;
import java.util.concurrent.ScheduledFuture;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.stereotype.Service;
import org.tctalent.anonymization.model.AnonCandidate;
import org.tctalent.util.background.BackProcessor;
import org.tctalent.util.background.BackRunner;
import org.tctalent.util.background.IdContext;

@Getter
@Setter
@RequiredArgsConstructor
@Service
public class PopulateDatabaseServiceImpl implements PopulateDatabaseService {
    private int percentageCpu;
    private ScheduledFuture<?> scheduledFuture;

    //TODO JC Only support one update at a time. New one cancels previous one (clear database).

    private final AnonymizationService anonymizationService;
    private final TalentCatalogService tcService;
    private final TaskScheduler taskScheduler;

    @Override
    public void populateDatabase(int percentageCPU) {
        if (scheduledFuture != null && !scheduledFuture.isDone()) {
            onFailedBuild();
        }

        this.percentageCpu = percentageCPU;

        BackRunner<IdContext> backRunner = new BackRunner<>();
        BackProcessor<IdContext> backProcessor = new BackProcessor<>() {
            @Override
            public boolean process(IdContext idContext) {
                return getDataFromTcServer(idContext);
            }
        };

        scheduledFuture = backRunner.start(taskScheduler, backProcessor,
                new IdContext(null, 1),
                percentageCpu);
    }

    private boolean getDataFromTcServer(IdContext ctx) {
        int pageNumber = ctx.getLastProcessedId() == null ? 0 : (int) (ctx.getLastProcessedId() + 1);


        System.out.println("Processing page " + pageNumber);

        try {
            String pageOfDataAsJson = tcService.fetchPageOfCandidateDataAsJson(pageNumber);
            Page<AnonCandidate> anonCandidates = anonymizationService.anonymizePage(pageOfDataAsJson);
            saveCandidates(anonCandidates.getContent());

            ctx.setLastProcessedId((long) pageNumber);

            return !anonCandidates.hasNext();
        } catch (JsonProcessingException e) {
            //TODO JC Need to handle renewing of token - ie logging in again.

            //TODO JC Otherwise fail the whole run
            onFailedBuild();
            e.printStackTrace();
            return false;
        }
    }

    private void onFailedBuild() {
        //Kill scheduling
        if (scheduledFuture != null && !scheduledFuture.isDone()) {
            scheduledFuture.cancel(true);
        }
        scheduledFuture = null;
        //Clear database
    }

    private void saveCandidates(List<AnonCandidate> content) {
        //TODO JC Implement saveCandidates
        throw new UnsupportedOperationException("saveCandidates not implemented");
    }
}
