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
			return self._find_closest(num, self.root)
		else:
			return None

	def _find_closest(self, num, node):
		if (node.l == None) and (node.r == None):
			return node
		elif node.l and node.r:
			if abs(node.l.v - num) <= abs(node.r.v - num):
				if abs(node.v - num) <= abs(node.l.v - num):
					return node
				else:
					return self._find_closest(num, node.l)
			else:
				if abs(node.v - num) < abs(node.r.v - num):
					return node
				else:
					return self._find_closest(num, node.r)
		elif node.l:
			if abs(node.v - num) <= abs(node.l.v - num):
				return node
			else:
				return self._find_closest(num, node.l)
		elif node.r:
			if abs(node.v - num) < abs(node.r.v - num):
				return node
			else:
				return self._find_closest(num, node.r)
		else:
			print "wtf"

	def path(self, num):
		if self.root is not None:
			path = "|"
			total = 0
			raw = self._path(num, self.root, total, path)
			#PUT STRIPPER HERE
			return raw
		else:
			return None

	def _path(self, num, node, total, path):
		path += str(node.v) + ", "
		tpath = path
		total += node.v
		print "-----------" + str(path)
		print "-----------" + str(total)
		if not node.l and not node.r:
			#if total == num:
			return str(node.v) + "|"
		if node.l:
			path += self._path(num, node.l, total, path)
		if node.r:
			tpath += self._path(num, node.r, total, tpath)
		if node.l and node.r:
			return path + tpath
		elif node.l:
			return path
		elif node.r:
			return tpath



print "Test Case 1\n"
my_tree = Tree()
my_tree.add(12)
my_tree.add(4)
my_tree.add(700)
answer = my_tree.find_closest(8)
print answer.v == 12
print answer.v
print "\n"

print "Test Case 2\n"
my_tree_dos = Tree()
my_tree_dos.add(12)
my_tree_dos.add(4)
my_tree_dos.add(18)
answer_dos = my_tree.find_closest(15)
print answer_dos.v == 12
print answer_dos.v
print "\n"

print "Test Case 3\n"
my_tree_tres = Tree()
answer = my_tree_tres.find_closest(12)
print answer == None
print answer
print "\n"

print "Test Case 4\n"
my_tree_cuatro = Tree()
my_tree_cuatro.add(10)
my_tree_cuatro.add(12)
my_tree_cuatro.add(5)
my_tree_cuatro.add(4)
my_tree_cuatro.add(7)
answer_4 = my_tree_cuatro.path(22)
print answer_4