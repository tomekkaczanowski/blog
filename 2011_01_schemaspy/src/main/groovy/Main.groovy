def command = """java -jar schemaspy-5.0.0.jar -t hsqldb -db mydb [-s schema] -u sa [-p password] -o outputDir"""// Create the String
def proc = command.execute()                 // Call *execute* on the string
proc.waitFor()