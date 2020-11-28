@Database
  Feature: Database Testing





    Scenario Outline: user gets the metadata
      Given user gets resultSet from database using "<url>" , "<username>" and "<password>"

      Examples:
      |url|username|password|
      |jdbc:postgresql://157.230.48.97:5432/gmibank_db|techprodb_user|Techpro_@126|


    Scenario Outline: user creates a country
      Given user creates a country using db "<url>" , "<username>" and "<password>"

      Examples:
        |url|username|password|
        |jdbc:postgresql://157.230.48.97:5432/gmibank_db|techprodb_user|Techpro_@126|
