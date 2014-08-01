polyglot
========

App prototype featuring Polyglot Context as described at https://github.com/fwbrasil/activate/blob/master/activate-docs/persistence-context.md#polyglot-context

This demonstrates how a Scala Play Web application can use 2 distinct datasources at the same time: MongoDB and PostgreSQL.

To run this Web App with SBT, you'll need:
- to have a MongoDB server up and listening
- to have a PostgreSQL server up and listening with a database named "polyglot"
- to update the file "app/Global.scala" with the proper credentials for your 2 databases
