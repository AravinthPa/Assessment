Feature: Validating the Form

Scenario: Enter the values in the form

Given open browser
When Navigate into URL "URL"
#Then click value in "Submit"
Then Type "FullName_Value" into "FullName"
Then Type "WorkEmail_Value" into "WorkEmail"
Then Type "Telephone_Value" into "Telephone"
Then Type "CompanyName_Value" into "CompanyName"
Then Select "Country_Value" from "Counrty"
Then click value in "LearnersCount"
Then Select "Role_Value" from "Role"
Then Select "PurposeOf_Value" from "PurposeOf"
Then click value in "Decleration"
Then click value in "Submit"