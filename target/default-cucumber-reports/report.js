$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/NewApplicant.feature");
formatter.feature({
  "name": "Register new applicants",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@NewApplicants"
    }
  ]
});
formatter.scenario({
  "name": "Just api calls for applicants",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@NewApplicants"
    },
    {
      "name": "@applicantApi"
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
  "name": "user creates an end-point",
  "keyword": "Given "
});
formatter.match({
  "location": "ApplicantApi.user_creates_an_end_point()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user gets all data for an applicant",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicantApi.user_gets_all_data_for_an_applicant()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});