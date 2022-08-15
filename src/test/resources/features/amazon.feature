Feature: Amazon senaryosu


  Scenario: Arama ve favori ürün ekleme
    When User go to amazon page
    Then User on the home page
    And Accept cookies
    Then Login the amazon page
    And User logged on the amazon
    Then  user select "Bilgisayarlar" category
    And  "Bilgisayarlar" category selected
    Then user type "msi" and search
    And user see search result
    Then user go to second page
    And  user see second page result
    Then user add the second product to favorite
    And user see product added to favorite
    Then user go to the list of favorite
    And user see list of favorite
    Then user deletes the product in the favorite list
    And user sees product is deleted
    Then user logout
    And user can logout