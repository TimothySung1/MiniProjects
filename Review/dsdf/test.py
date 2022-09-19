'''
Created on Jan 28, 2021

@author: tsung
'''

#list of months in season. If the month is in the list, it is  guaranteed to be in the corresponding season.
spring = ["April", "May"]
summer = ["July", "August"]
fall = ["October", "November"]
winter = ["January", "February"]

def season(month, day):
    #string of the season being returned
    the_season = ""
    
    #These if / elif blocks check if the month is in a guaranteed season by checking if it's in the list of seasons. Day doesn't matter.
    if month in spring:
        the_season = "Spring"
    if month in summer:
        the_season = "Summer"
    if month in fall:
        the_season = "Fall"
    if month in winter:
        the_season = "Winter"
    
    #the else condition will run if the month is not in a guaranteed season (the month is not found in any of the lists of seasons. day does matter)
    else:
        #check if the month is one that changes season on a day
        if month == "March":
            if day >= 20:
                the_season = "Spring"
            else:
                the_season = "Winter"
        elif month == "June":
            if day >= 20:
                the_season = "Summer"
            else:
                the_season = "Spring"
        elif month == "September":
            if day >= 22:
                the_season = "Fall"
            else:
                the_season = "Summer"
        elif month == "December":
            if day >= 21:
                the_season = "Winter"
            else:
                the_season = "Fall"
    return the_season
#the list of months and days is used to check if the inputted month is valid and to check the day limit.
months = ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"]
days = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
month_invalid = True
day_invalid = True
while True:
    #loop the code that asks the user for a month if the user inputs an invalid month. 
    while month_invalid:
        #the variable month contains the string of the month the user inputs
        month = input("Enter a month (Capitalize the starting letter): ")
        #check if the inputted month is in the list of valid months. If not, the user is asked again.
        if month in months:
            month_invalid = False
        else:
            print("You did not enter a valid month. Try again.")
            
    #loop through the list of all the months. Depending on the month, the maximum day is set and the inputted day must be less than that number
    max_day = 0
    for i in range(12):
        if months[i] == month:
            max_day = days[i]
    #loop the code if the user inputs an invalid day
    while day_invalid:
        #the variable day contains the number of the date.
        #the try and except ensures that the code doesn't break if the user inputs a string or doesn't input a number
        try:
            day = int(input("Enter a day: "))
            #if the number is a valid date in the month, the code continues. Otherwise, it loops and asks the user again.
            if day > 0 and day <= max_day:
                day_invalid = False
            else:
                print("You did not enter a valid day. Try again.")
        except:
            print("Input an integer")
        
        
    
    #run the function season() inside the print function, printing the calculated season
    print("The season is " + season(month, day))
    
    #the loop variable checks if the user wants to input more months/days
    loop = input("Do you want to continue? Enter Yes or Stop: ")
    #if the user inputs Stop, the program prints an exit string and breaks the loop
    if loop == "Stop":
        print("Thank you for running the program.")
        break