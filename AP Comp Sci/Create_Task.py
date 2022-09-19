#Geometry cheat sheet/physics cheat sheet how use for or while loop?
#DIY quiz? Matching game? Fit budget? shop sell stuff user choose how much?
#mean median mode?? find mean median mode range etc of a list of numbers inputted by user. how use if statement and for loop? for loop and if statement to get the mode.

def print_list(items):
    pass
    
def calc_mean(nums):
    total = 0
    for i in range(len(nums)):
        total += nums[i]
    mean = total / len(nums)
    return mean

def calc_median(nums):
    if len(nums) % 2 == 0:
        median = (nums[int((len(nums) / 2) - 1)] + nums[int(len(nums) / 2)]) / 2
    
    else:
        median = nums[int((len(nums) / 2) - .5)]
    return median

def calc_mode(nums):
    #use for loop, dictionary or list, and if statement. satisfy requirements for project.
    numbers_set = {}
    for num in nums:
        if numbers_set.__contains__(num):
            numbers_set[num] += 1
        else:
            numbers_set[num] = 1
            
    modes = []
    highest = 0
    for num, frequency in numbers_set.items():
        if frequency > highest:
            highest = frequency
            modes.clear()
            modes.append(num)
        elif frequency == highest:
            modes.append(num)
    return modes

def calc_range(nums):
    set_range = nums[-1] - nums[0]
    return set_range

def get_min(nums):
    set_min = nums[0]
    return set_min

def get_max(nums):
    set_max = nums[-1]
    return set_max

def get_Q1(nums):
    if len(nums) % 2 == 0:
        bottom_half = nums[0: int(len(nums) / 2)]
        
    else:
        bottom_half = nums[0: int((len(nums) / 2) - .5)]
    q1 = calc_median(bottom_half)
    return q1

def get_Q3(nums):
    if len(nums) % 2 == 0:
        top_half = nums[int(len(nums) / 2): len(nums)]
        
    else:
        top_half = nums[int((len(nums) / 2) + .5): len(nums)]
    q3 = calc_median(top_half)
    return q3

def get_outliers(nums):
    if len(nums) % 2 == 0:
        top_half = nums[int(len(nums) / 2): len(nums)]
        bottom_half = nums[0: int(len(nums) / 2)]
        
    else:
        top_half = nums[int((len(nums) / 2) + .5): len(nums)]
        bottom_half = nums[0: int((len(nums) / 2) - .5)]
        
    lower_bound = get_Q1(nums) - (1.5 * calc_IQR(nums))
    upper_bound = get_Q3(nums) + (1.5 * calc_IQR(nums))
    outliers = []
    for num in bottom_half:
        if num < lower_bound:
            outliers.append(num)
        
    for num in top_half:
        if num > upper_bound:
            outliers.append(num)
    
    if len(outliers) == 0:
        return ["No outliers"]
    return outliers

def calc_IQR(nums):
    iqr = get_Q3(nums) - get_Q1(nums)
    return iqr

def calc_SD(nums):
    pass

def instructions():
    print("This program will print the number of numbers, mean, median, mode, range, minimum, quartile 1, quartile 3, maximum, and outliers of an inputted set of numbers.")
    print("The mean is the average of a set of numbers.\nThe median is the value in the middle of a set of numbers.\nThe mode is the value that is most frequent in a set of numbers.\nThe range is the difference of the highest value and lowest value in a set of numbers.\n")
    

#another possible idea: get even numbers and odd numbers, maybe print out a dotplot? prolly not
print("Welcome to a basic statistics calculator. You will enter a list of numbers, and the program will print out the mean, median, mode, range, quartile 1, quartile 3, outliers, and interquartile range values.")

need_help = input("Would you like to read additional details and instructions about the program? [Yes, No] ")
if need_help == "Yes":
    instructions()

invalid = True
while invalid:
    try:
        input_numbers = input("Please enter at least 4 numbers. Separate each number with a space. ").split(" ")
        numbers = []
        for num in input_numbers:
            numbers.append(int(num))
        numbers.sort()
        if len(input_numbers) < 4:
            print("Please input at least 4 numbers.")
        else:
            invalid = False
    except:
        print("Make sure you have inputted integers that are divided by spaces.")


print("Numbers: " + str(len(numbers)))
print("Mean: " + str(calc_mean(numbers)))
print("Median: " + str(calc_median(numbers)))
print("Mode: ", end = "")
print(*calc_mode(numbers), sep = ", ")
print("Range: " + str(calc_range(numbers)))
print("Minimum: " + str(get_min(numbers)))
print("Quartile 1: " + str(get_Q1(numbers)))
print("Quartile 3: " + str(get_Q3(numbers)))
print("Maximum: " + str(get_max(numbers)))
print("Outliers: ", end = "")
print(*get_outliers(numbers), sep = ", ")
