package pl.kaczanowscy.tomek.schemaspy

import net.sourceforge.schemaspy.Config
import net.sourceforge.schemaspy.SchemaAnalyzer

import org.hsqldb.Server
import org.hsqldb.util.SqlFile
import java.sql.DriverManager
import java.sql.Connection

import groovy.sql.Sql

/**
 * Code for http://kaczanowscy.pl/tomek/2011-01/database-diagrams-with-schemaspy-hsqldb-and-groovy blog post.
 * 
 * @author Tomek Kaczanowski
 */
class GenerateSqlDiagram {

  static final String DB_NAME = "xdb"
  static final String HOST = "localhost"
  static final String SCHEMA = "PUBLIC"
  static final String OUTPUT_DIR = "build/schema/"


  static void main(String[] args) {
    args.each {
      println "\n\nFILE: " + it
      String fileName= it.split("/")[1][0 .. -5]


    def hsqlServer = new Server()
    hsqlServer.setDatabaseName(0, "xdb");
    hsqlServer.setDatabasePath(0, "mem:testdb");
    hsqlServer.start()

    def embeddedDbSettings = [url:'jdbc:hsqldb:hsql://' + HOST + '/' + DB_NAME,
                user:'sa', password:'', driver:'org.hsqldb.jdbcDriver'];

    def sql =  Sql.newInstance(embeddedDbSettings);

    String[] commands = new File(it).text.split(";");

    for(String command: commands) {
    // new line is a delimiter in hsqldb
      sql.execute command.replace("\n", " ");
    }

    def conf = new Config(args)

    conf.setOutputDir OUTPUT_DIR + fileName
    conf.setUser "sa"
    conf.setDbType "hsqldb"
    conf.setHost HOST
    conf.setSchema SCHEMA
    conf.setDb DB_NAME

    conf.setHighQuality true
    conf.setNumRowsEnabled false
    conf.setAdsEnabled false

    def sa = new SchemaAnalyzer()
    sa.analyze(conf)

    sql.execute "SHUTDOWN"
    sql.close();
      hsqlServer.stop()
    }
  }
}