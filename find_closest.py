class Node(object):
	def __init__(self, val):
		self.v = val
		self.l = None
		self.r = None

class Tree(object):
	def __init__(self):
		self.root = None

	def set_root(self, val):
		self.root = val

	def get_root(self):
		return self.root

	def add(self, val):
		if self.root:
			self._add(val, self.root)
		else:
			self.set_root(Node(val))

	def _add(self, val, node):
		if val < node.v:
			if node.l:
				self._add(val, node.l)
			else:
				node.l = Node(val)
		else:
			if node.r:
				self._add(val, node.r)
			else:
				node.r = Node(val)

	def find_closest(self, num):
		if self.root:
			self._find_closest(num, self.root)
		else:
			return None

	def _find_closest(self, num, node):
		if (node.l == None) and (node.r == None):
			print "1"
			return node
		elif node.l and node.r:
			if abs(node.l.v - num) < abs(node.r.v - num):
				print "2"
				if abs(node.v - num) < abs(node.l.v - num):
					print "2-1"
					return node
				else:
					print "2-2"
					self._find_closest(num, node.l)
			else:
				print "3"
				if abs(node.v - num) < abs(node.r.v - num):
					print "3-1"
					return node
				else:
					print "3-2"
					self._find_closest(num, node.r)
		elif node.l:
			print "4"
			if abs(node.v - num) < abs(node.l.v - num):
				print "4-1"
				print node.v
				return node.v
			else:
				print "4-2"
				self._find_closest(num, node.l)
		elif node.r:
			print "5"
			if abs(node.v - num) < abs(node.r.v - num):
				print "5-1"
				return node
			else:
				print "5-2"
				self._find_closest(num, node.r)
		else:
			print "wtf"

	def subnode_greater_than(self):
		pass


my_tree = Tree()
my_tree.add(10)
my_tree.add(7)
my_tree.add(12)
my_tree.add(5)
my_tree.add(2)
answer = my_tree.find_closest(4)
print answer