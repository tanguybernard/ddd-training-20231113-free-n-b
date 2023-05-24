Feature: Renseigner PTO dans intervention


Scenario: Intervention cree, le technicien entre le numéro de PTO

    Given I have intervention "i123"
    When Technicien fill PTO number "4567" for intervention "i123"
    Then the reponse will return status 200