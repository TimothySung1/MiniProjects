"""print("Hello World")

response = input('What\'s your name?\n')
print('Hello', response)

for c in response:
    print(ord(c))
"""    


i = 1
while i < 11:
    print(i)
    i += 2
    
l = [0] * 10

for i in l:
    print(i)

for i in range(0, 10):
    l[i] = i + 1
print(max(l))
print(sum(l))
l.append(11)
l.insert(5, 12)
print(l)
l.sort()
print(l)

a = "hello"
b = "world"

print(a, end = " ")
print(b)

