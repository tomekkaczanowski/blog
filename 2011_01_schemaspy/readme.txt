This is a slightly enhanced version of code described at http://kaczanowscy.pl/tomek/2011-01/database-diagrams-with-schemaspy-hsqldb-and-groovy

It generates diagrams for many files (given as command line parameters)

compile with
  gradle clean jar

run with
  java -cp build/libs/2011_01_schemaspy.jar pl.kaczanowscy.tomek.schemaspy.GenerateSqlDiagram sql/inventory.sql sql/whatever.sql
  
