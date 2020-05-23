# Description:
# Write a program that outputs the string representation of numbers from 1 to n.
# But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”. 
# For numbers which are multiples of both three and five output “FizzBuzz”.
# Example output: ["1", "2", "Fizz", "4", "Buzz", "Fizz" ...]

# Using a list comprehension
set = ['fizzBuzz' if i % 15 == 0 else 'fizz' if i % 3 == 0 else 'buzz' if i % 5 == 0 else str(i) for i in range(1,101)]
print(set)