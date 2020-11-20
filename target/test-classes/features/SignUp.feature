@SignUp
Feature: SignUp page for GMI Bank




  @signUp
    Scenario: sign up

      Given user on the sign up page
      And user provides SSN number using "777-555-33"
      When customer provides firstname and password as "customer1" and "customer12345"
      And customer provides "2729 Gallows road No: 108"
      Then customer provides mobile phone as "2024998460"
      And customer provides username as "techproed"
      Then user provides email as "hisetkal@gmail.com"
      And customer creates a password "customer12345"
      When customer confirms password "customer12345"
      Then customer clicks on register button


    @123
    Scenario Outline: all users
      Given user on the sign up page
      And user types SSN number "<SSN>"
      When user types "<firstName>" and "<lastName>"


      Examples: all data
      |SSN|firstName| lastName|
