# Talent Catalog Anonymization Service #

## Overview ##

This service implements the 
[Talent Catalog Anonymization Service API](https://github.com/Talent-Catalog/tc-anonymization-service-spec)

## How do I get set up? ##

### Install the tools ###

> IMPORTANT NOTE:
>
> These instructions are tailored for Mac users using Intellij, as this is what we use for
> development.
>
> On a Mac, installing with Homebrew usually works well. eg "brew install xxx".
>
> It is also probably easier to install Java directly (or from your development IDE - see below) 
> rather than using brew.

Download and install the latest of the following tools.

- Homebrew - [Homebrew website](https://brew.sh)

- IntelliJ IDEA - [Intellij website](https://www.jetbrains.com/idea/download/)
    - Import standard settings and run configurations from another developer
    - In development, it is best to build using Intellij rather than gradle. Change the Intellij
      setting for "Build, Execution & Deployment" > "Build Tools" > "Gradle" to build with Intellij.

- Java 17
    - The current version of Java supported is Java 17. We use the Temurin release (however there
      should be no issues using other releases). **One way** (but you can choose whichever method
      you like) to manage Java versions is with **sdkman**. A .sdkmanrc file exists when you check 
      out the repository. You can get **sdkman** by running the following:

      ```
      curl -s "https://get.sdkman.io" | bash
      source "$HOME/.sdkman/bin/sdkman-init.sh"
      sdk install 17.0.11-tem
      ```

    - Intellij will load the JDK through the .sdkmanrc file.
    - Update the Project SDK:
        - Go to File / Project Structure / Project and set the SDK to your chosen JDK.
        - On the same page, ensure the language level matches your chosen SDK version.
    - IntelliJ Settings:
        - Go to IntelliJ / Settings / Build,Execution,Deployment / Compiler / Java Compiler
            - Add `-parameters` to the`Additional command line parameters` textbox.
            - Set the `Project bytecode version` to match the JDK chosen (e.g. **17**).
        - Go to IntelliJ / Settings / Build,Execution,Deployment / Build Tools / Gradle
            - Set the **GradleJVM** from the drop list to use the Project SDK.


- Code Style
    - Download the intellij-java-google-style.xml file from the google/styleguide repository
      [here](https://github.com/google/styleguide/blob/gh-pages/intellij-java-google-style.xml).
    - Launch IntelliJ and go to the **IntelliJ > Settings...** menu and expand the **Code Style**
      sub-menu underneath Editor. Here, you will see a list of supported languages. Select **Java**.
    - Next to the Scheme drop-down menu select the gear icon then **Import Scheme > IntelliJ IDEA
      code
      style XML** then select the intellij-java-google-style.xml file you downloaded from GitHub.
    - Give the schema a name (or use the default GoogeStyle name from the import). Click **OK** or
      **Apply** for the settings to take effect.


- Gradle [https://gradle.org/install/](https://gradle.org/install/)
  ```
  brew install gradle
  ```

- Git - [see Git website](https://git-scm.com/downloads) - Not really necessary now with Intellij
  which will prompt you to install Git if needed.


- Docker and docker-compose
    - Install Docker Desktop for Mac -
      see [docker website](https://hub.docker.com/editions/community/docker-ce-desktop-mac/)
    - Note for Mac Silicon users. The current Docker doc (link above) implies that installing
      Rosetta is optional.
      But if you don't do it you won't be able to install Docker.
      You need to execute softwareupdate --install-rosetta just to run Docker for the first time
      after installing it.
    - When you install Docker Desktop for Mac, Docker Compose is bundled with it. You can verify the
      installation by running:
      ```shell
        docker-compose --version
      ```

### Clone the TC Anonymization Service and Specification repositories from Git ###

- Clone [the service](https://github.com/Talent-Catalog/tc-anonymization-service.git) to your local system
```shell
git clone https://github.com/Talent-Catalog/tc-anonymization-service.git
```
- Open the root folder in IntelliJ IDEA (it should auto detect gradle and self-configure)

- Clone [the OpenAPI specification](https://github.com/Talent-Catalog/tc-anonymization-service-spec.git) 
to your local system
```shell
git clone https://github.com/Talent-Catalog/tc-anonymization-service-spec.git
```
- Open the root folder in IntelliJ IDEA as a Module - IntelliJ > File > New > Module from Existing 
Sources

### Using Docker-Compose to Start Services ###

With Docker and Docker Compose installed, you can now use docker-compose to set up the required
services: Mongo, and optionally, Mongo Express.

- The Anonymization Service repository includes a docker-compose.yml file in the docker-compose 
  folder, with preconfigured services for Mongo and Mongo Express. This file is ready for you to 
  use.
- To start the services, navigate to the docker-compose folder and run the following command:
```shell
cd talentcatalog/docker-compose
docker-compose up -d
```
- The -d flag runs the services in detached mode.
- To stop the services, run the following command:
```shell
docker-compose down
```

### Using IntelliJ’s Docker-Compose Integration to Start Services ###

IntelliJ IDEA provides built-in support for Docker Compose, allowing you to start and stop services
directly from the IDE, either from the Services tool window or directly from the docker-compose.yml
file itself.

- In the Project tool window, navigate to and open the docker-compose.yml file.
- IntelliJ adds green Run/Debug triangles in the gutter (left margin) next to each service in the
  docker-compose.yml file.
- Click on the green Run triangle next to a service (e.g., mongo) to start that specific service.
- You can also click the Run triangle next to the services block at the top of the file to start all
  services at once.

### Verify Services ###

The following services will all run from the Docker container:

- **Mongo** (listening on port 27017)
- **Mongo Express** (8081)

Verify with the following terminal command:
```shell
docker ps
```

### Set up your local database ###

The TC anonymization service is designed to run in a cloud environment alongside the TC core 
service. You should have the TC core service and database running locally before proceeding. See
the [talentcatalog](https://github.com/Talent-Catalog/talentcatalog) repository for further details.

Once you have a local TC core service and database installed and running, you can run the 
TcAnonymizationServiceApplication from IntelliJ - see 'Run the server' below for further details. 

At the time of writing this ReadMe he application is configured to immediately start a batch job 
that will read candidate data from the TC core database, map this to anonymised candidate data, and 
save the anonymised data to Mongo database.

### Run the server ###

Before running the server, you must generate the model and api classes that the service needs. The 
schema for these are defined in the OpenAPI specification in tc-anonymization-service-spec which you 
imported to IntelliJ as an additional module.

From the tc-anonymization-service root folder, execute the Gradle command: 

```shell
./gradlew clean openApiGenerate
```

Then generate the Mapstruct mapper classes that the service uses to map from TC core data to 
anonymised candidate data. From the tc-anonymization-service root folder, execute the Gradle 
command:

```shell
./gradlew compileJava
```

You can now start the anonymization service:

- Create a new Run Profile for `org.tctalent.anonymization.TcAnonymizationServiceApplication`.
  In the Environment Variables section of Intellij, check the "Include system environment variables" 
  checkbox.
- Run the new profile, you should see something similar to this in the logs:

```
Started TcAnonymizationServiceApplication in 3.179 seconds (process running for 3.424)
```

- Your server will be running on port 8082 (as defined in server.port in application.yml).
- At the time of writing this Readme, the server initiates a batch process on startup that reads 
  data from the TC core database, maps it to anonymised data, and writes this to Mongo.
- You can test it the server with a tool such as Postman by issuing a GET to the following endpoint: 
  [http://localhost:8082/v1/candidates](http://localhost:8082/v1/candidates)

### Connect IntelliJ to your database ###

- File > New > Data Source > MongoDB > MongoDB
- Give the DB a name that clearly identifies it as your local development version.
- Populate the other setup parameters with the default values in the `mongo` configuration of the 
  project file `docker-compose.yml`.

## Version Control ##

We use GitHub. Our repository is called tc-anonymization-service -
[https://github.com/Talent-Catalog/tc-anonymization-service](https://github.com/Talent-Catalog/tc-anonymization-service)

See the [GitHub wiki](https://github.com/Talent-Catalog/tc-anonymization-service/wiki)
for additional documentation.

### Master branch ###

The main branch is "master". We only merge and push into "master" when we are ready to deploy to 
production (rebuild and upload of build artifacts to the production environment is automatic, 
triggered by any push to "master". See Deployment section below).

Master should only be accessed directly when staging is merged into it, triggering deployment to 
production. You should not do normal development in Master.

### Staging branch ###

The "staging" branch is used for code which is potentially ready to go into production. Code is 
pushed into production by merging staging into master and then pushing master. See Deployment 
section below.

Staging is a shared resource so you should only push changes there when you have finished changes 
which you are confident will build without error and should not break other parts of the code.

As a shared resource, staging is the best way to share your code with other team members to allow 
them to merge your code into their own branches and also to allow them to review your code and help 
with testing.

Rebuild and upload of build artifacts to the AWS testing environment is automatic when any push is 
made to "staging".

### Personal branches ###

New development should be done in branches.

Typically, you should branch from the staging branch, and merge regularly (eg daily) from staging 
so that your code does not get too far away from what everyone else is doing.

When you are ready to share your code for others to take a look at and for final joint testing and 
eventual deployment, merge your branch into staging.

On your branch you should commit often - doing separate commits for specific functionality, rather 
than lumping different kinds of functionality into a single big commit. That makes commits simpler 
to review and understand. It also makes it easier to revert specific functionality when you have got
something wrong and decide to start again, doing it differently.

You should feel comfortable pushing regularly - often doing Commit and Push at the same time. 
Pushing is effectively saving your work into the "cloud" rather having changes just saved on your 
computer.

## Deployment and Monitoring ##

See the Deployment and Monitoring pages on the
[GitHub wiki](https://github.com/Talent-Catalog/tc-anonymization-service/wiki).

## License

[GNU AGPLv3](https://choosealicense.com/licenses/agpl-3.0/)

