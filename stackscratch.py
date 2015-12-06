class Stack(object):
	def __init__(self):
		self.items = []

	def isempty(self):
		return self.items == []

	def pop(self):
		return self.items.pop()

	def push(self, val):
		self.items.append(val)

	def top(self):
		return self.items[len(self.items) - 1]

	def size(self):
		return len(self.items)


zackstack = Stack()

print zackstack.isempty()
zackstack.push(4)
print zackstack.top()
print zackstack.isempty()
print zackstack.pop()
print zackstack.isempty()
zackstack.push(5)
print zackstack.size()

class Queue(object):
	def __init__(self):
		self.items = []

	def isempty(self):
		return self.items == []

	def dequeue(self):
		self.items.pop(0)

	def enqueue(self, val):
		self.items.append(val)

	def examine(self):
		return self.items[0]

zaq = Queue()
print zaq.items
print zaq.isempty()
zaq.enqueue(1)
zaq.enqueue(2)
zaq.enqueue(3)
zaq.enqueue(4)
print zaq.items
print zaq.examine()
print zaq.isempty()
print zaq.dequeue()
print zaq.items