$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/Database.feature");
formatter.feature({
  "name": "all data validation based on DB",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@database"
    }
  ]
});
formatter.scenarioOutline({
  "name": "read all customer info",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@deneme23"
    }
  ]
});
formatter.step({
  "name": "user gets all customer column data using \"\u003cquery\u003e\" and \"\u003ccolumnName\u003e\" and \"\u003cfileType\u003e\"",
  "keyword": "Given "
});
formatter.step({
  "name": "user validates all db Customer info2",
  "keyword": "Then "
});
formatter.examples({
  "name": "all Customer data sets",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "query",
        "columnName",
        "fileType"
      ]
    },
    {
      "cells": [
        "Select * from tp_customer",
        "ssn",
        "customerSSN.txt"
      ]
    },
    {
      "cells": [
        "Select * from tp_customer",
        "first_name",
        "customerFirstNames.txt"
      ]
    },
    {
      "cells": [
        "Select * from tp_customer",
        "zip_code",
        "customerZipCode.txt"
      ]
    },
    {
      "cells": [
        "select * from tp_country",
        "name",
        "countryNames.txt"
      ]
    },
    {
      "cells": [
        "Select * from tp_state",
        "name",
        "stateNames.txt"
      ]
    }
  ]
});
formatter.background({
  "name": "create a connection with DB",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user creates a connection with db using \"jdbc:postgresql://157.230.48.97:5432/gmibank_db\" , \"techprodb_user\" and \"Techpro_@126\"",
  "keyword": "Given "
});
formatter.match({
  "location": "DatabasePostgresSteps.user_creates_a_connection_with_db_using_and(String,String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "read all customer info",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@database"
    },
    {
      "name": "@deneme23"
    }
  ]
});
formatter.step({
  "name": "user gets all customer column data using \"Select * from tp_customer\" and \"ssn\" and \"customerSSN.txt\"",
  "keyword": "Given "
});
formatter.match({
  "location": "DatabasePostgresSteps.user_gets_all_customer_column_data_using_and_and(String,String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user validates all db Customer info2",
  "keyword": "Then "
});
formatter.match({
  "location": "DatabasePostgresSteps.user_validates_all_db_Customer_info(Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.background({
  "name": "create a connection with DB",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user creates a connection with db using \"jdbc:postgresql://157.230.48.97:5432/gmibank_db\" , \"techprodb_user\" and \"Techpro_@126\"",
  "keyword": "Given "
});
formatter.match({
  "location": "DatabasePostgresSteps.user_creates_a_connection_with_db_using_and(String,String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "read all customer info",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@database"
    },
    {
      "name": "@deneme23"
    }
  ]
});
formatter.step({
  "name": "user gets all customer column data using \"Select * from tp_customer\" and \"first_name\" and \"customerFirstNames.txt\"",
  "keyword": "Given "
});
formatter.match({
  "location": "DatabasePostgresSteps.user_gets_all_customer_column_data_using_and_and(String,String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user validates all db Customer info2",
  "keyword": "Then "
});
formatter.match({
  "location": "DatabasePostgresSteps.user_validates_all_db_Customer_info(Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.background({
  "name": "create a connection with DB",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user creates a connection with db using \"jdbc:postgresql://157.230.48.97:5432/gmibank_db\" , \"techprodb_user\" and \"Techpro_@126\"",
  "keyword": "Given "
});
formatter.match({
  "location": "DatabasePostgresSteps.user_creates_a_connection_with_db_using_and(String,String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "read all customer info",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@database"
    },
    {
      "name": "@deneme23"
    }
  ]
});
formatter.step({
  "name": "user gets all customer column data using \"Select * from tp_customer\" and \"zip_code\" and \"customerZipCode.txt\"",
  "keyword": "Given "
});
formatter.match({
  "location": "DatabasePostgresSteps.user_gets_all_customer_column_data_using_and_and(String,String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user validates all db Customer info2",
  "keyword": "Then "
});
formatter.match({
  "location": "DatabasePostgresSteps.user_validates_all_db_Customer_info(Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.background({
  "name": "create a connection with DB",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user creates a connection with db using \"jdbc:postgresql://157.230.48.97:5432/gmibank_db\" , \"techprodb_user\" and \"Techpro_@126\"",
  "keyword": "Given "
});
formatter.match({
  "location": "DatabasePostgresSteps.user_creates_a_connection_with_db_using_and(String,String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "read all customer info",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@database"
    },
    {
      "name": "@deneme23"
    }
  ]
});
formatter.step({
  "name": "user gets all customer column data using \"select * from tp_country\" and \"name\" and \"countryNames.txt\"",
  "keyword": "Given "
});
formatter.match({
  "location": "DatabasePostgresSteps.user_gets_all_customer_column_data_using_and_and(String,String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user validates all db Customer info2",
  "keyword": "Then "
});
formatter.match({
  "location": "DatabasePostgresSteps.user_validates_all_db_Customer_info(Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.background({
  "name": "create a connection with DB",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user creates a connection with db using \"jdbc:postgresql://157.230.48.97:5432/gmibank_db\" , \"techprodb_user\" and \"Techpro_@126\"",
  "keyword": "Given "
});
formatter.match({
  "location": "DatabasePostgresSteps.user_creates_a_connection_with_db_using_and(String,String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "read all customer info",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@database"
    },
    {
      "name": "@deneme23"
    }
  ]
});
formatter.step({
  "name": "user gets all customer column data using \"Select * from tp_state\" and \"name\" and \"stateNames.txt\"",
  "keyword": "Given "
});
formatter.match({
  "location": "DatabasePostgresSteps.user_gets_all_customer_column_data_using_and_and(String,String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user validates all db Customer info2",
  "keyword": "Then "
});
formatter.match({
  "location": "DatabasePostgresSteps.user_validates_all_db_Customer_info(Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});