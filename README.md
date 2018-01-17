# tc_project

How to execute test using gradle:

<code>gradle {module}:{task} -Denv={env}</code>

For example:<br>

<code>gradle frontend:test -Denv=QA</code><br>

or<br>

<code>gradle frontend:smokeTest -Denv=QA -Dbrowser=chrome  - run scenarious with tag @smokeTest on Chrome browser</code><br>

or<br>

<code>gradle backend:runFeature -Denv=QA -Dfeature=user_posts</code> - run single feature 'user_posts.feature'

Intelij IDEA required plugins: <br>
Cucumber for Java - https://plugins.jetbrains.com/plugin/7212-cucumber-for-java <br>
Lombok Plugin - https://plugins.jetbrains.com/plugin/6317-lombok-plugin <br>

To make lombok works properly you have to enable annotation processing in your IDE
