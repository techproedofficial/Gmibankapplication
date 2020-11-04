$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/main/resources/features/DummyApi.feature");
formatter.feature({
  "name": "Dummy Test can be verified",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "database testing",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@database"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user gets all data from database",
  "keyword": "Given "
});
formatter.match({
  "location": "DatabaseStep.user_gets_all_data_from_database()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});