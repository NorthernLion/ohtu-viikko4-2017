Feature: A new user account can be created if a proper unused username and password are given

  Scenario: creation succesful with correct username and password
    Given new user is selected
    When  valid username "markku" and valid password "markku12" are given
    Then  user is created and message "Welcome to Ohtu Application!" is shown

  Scenario: creation fails with too short username and valid passord
    Given new user is selected
    When  invalid username "ma" and valid password "markku12" are given
    Then user "markku" is not created and error "username should have at least 3 characters" is reported

  Scenario: creation fails with correct username and too short password
    Given new user is selected
    When  valid  username "markku" and invalid password "mar" are given
    Then user "markku" is not created and error "password should have at least 8 characters" is reported

  Scenario: creation fails with correct username and password consisting of letters
    Given new user is selected
    When  valid  username "markku" and invalid password "mar" are given
    Then user "markku" is not created and error "password can not contain only letters" is reported

  Scenario: creation fails with already taken username and valid pasword
    Given user "markku" is created
    And new user is selected
    When  valid  username "markku" and invalid password "mar" are given
    Then user "markku" is not created and error "username is already taken" is reported

  Scenario: creation fails when password and password confirmation do not match
    Given new user is selected
    When  valid username "markku" and valid password "markku12" are given
    And   invalid password confirmation "markku" is given
    Then user "markku" is not created and error "password and password confirmation do not match" is reported