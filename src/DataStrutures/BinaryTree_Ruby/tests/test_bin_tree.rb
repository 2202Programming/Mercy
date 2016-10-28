#!/usr/bin/ruby -w

require "./bin_tree.rb"
require "test/unit"

class TestGame < Test::Unit::TestCase

  def setup()
    @tree = BinarySearchTree::BinTree.new
    @tree.insert(50)
    @tree.insert(25)
    @tree.insert(75)
    @tree.insert(12)
    @tree.insert(37)
    @tree.insert(87)
    @tree.insert(63)
  end
    
  def test_creation()
    assert_not_nil(@tree)
  end

  def test_balanced()
    assert(@tree.is_balanced?)
  end

  def test_in_order()
    arr = Array.new
    t_arr = [12, 25, 37, 50, 63, 75, 87]
    
    @tree.in_order do |node|
      arr.push(node.datum)
    end

    assert_equal(arr, t_arr)
  end

  def test_pre_order()
    arr = Array.new
    t_arr = [50, 25, 12, 37, 75, 63, 87]

    @tree.pre_order do |node|
      arr.push(node.datum)
    end

    assert_equal(arr, t_arr)    
  end

  def test_post_order()
    t_arr = [12, 37, 25, 63, 87, 75, 50]
    arr = Array.new

    @tree.post_order do |node|
      arr.push(node.datum)
    end

    assert_equal(arr, t_arr)
  end
end

require 'test/unit/ui/console/testrunner'
Test::Unit::UI::Console::TestRunner.run(TestGame)
