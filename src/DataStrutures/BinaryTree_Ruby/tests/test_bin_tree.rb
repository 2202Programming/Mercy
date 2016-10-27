#!/usr/bin/ruby -w

require_relative "../bin_tree.rb"
require "test/unit"

class TestBinTree < Test::Unit::TestCase

  def setup
    @tree = BinarySearchTree::BinTree.new
  end
    
  def creationTest
    raise if @tree.nil?
  end
    
  def simpletest
  end
end

require 'test/unit/ui/console/testrunner'
Test::Unit::UI::Console::TestRunner.run(TestBinTree)

=begin
tree = BinarySearchTree::BinTree.new
tree.insert(50)
tree.insert(25)
tree.insert(75)
tree.insert(12)
tree.insert(37)
tree.insert(87)
tree.insert(63)
puts tree.inspect
puts "tree.is_balanced?"
puts tree.is_balanced?

puts "pre_order"
tree.pre_order do |node|
  puts node.datum
end

puts "in_order"
tree.in_order do |node|
  puts node.datum
end

puts "post_order"
tree.post_order do |node|
  puts node.datum
end

=end
