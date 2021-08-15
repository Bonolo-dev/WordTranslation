Write an application that goal will be to translate sentences based on the dictionary. Attached file
contains words with their translations. Read it to the program's memory. Add 2 rest endpoints:
- first to translate sentences based on the dictionary in 2 modes
a) replace each word to its translation
b) same as a but each word has to be in quotes
- second to get ranking of dictionary usage. Ranking should show a list of words with the number of
their usages sorted by this number.
Please focus on the program architecture, assume that each functionality will be enhanced in the
future. Remember about tests.

API test data
1.)Translation
{
    "translateData":"whatever fight a cat you want so rought trousers the helm has inbetween somthing has and also has a cat soldier white whit white soldier",
    "mode":0 or 1

}
2.) Word ranking
{
    "translateData":"whatever fight a cat you want so rought trousers the helm has inbetween somthing has and also has a cat soldier white whit white soldier",
    "mode":0 

}

Bonolo Postman Request.postman_collection.json has post man requests
