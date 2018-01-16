# tc_project

How to execute test using gradle:

<code>gradle {module}:{task} -Denv={env}</code>

For example:<br>

<code>gradle frontend:test -Denv=QA</code><br>

or<br>

<code>gradle frontend:smokeTest -Denv=QA -Dbrowser=chrome  - run scenarious with tag @smokeTest on Chrome browser</code><br>

or<br>

<code>gradle backend:runFeature -Denv=QA -Dfeature=user_posts</code> - run single feature 'user_posts.feature'
