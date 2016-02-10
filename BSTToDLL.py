class Node(object):
  def __init__(self, val):
    self.val = val
    self.leftchild = None
    self.rightchild = None

class Tree(object):
  def __init__(self):
    self.root = None

  def add(self,value):

def inorder(ptr, prev, head):
  inorder(ptr.left, prev, head)
  ptr.left = prev
  if (prev IS not None):
    prev.right = ptr
  else
    head = ptr

  right = ptr.right
  head.left = ptr
  ptr.right = head

  prev = ptr

  inorder(ptr.right, prev, head)



tree = Tree()
tree.add(4)
tree.add(7)
tree.add(8)
tree.add(2)
tree.add(0)
inorder(tree.get_root(), None, None)

