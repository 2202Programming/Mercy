#!/usr/bin/ruby -w

require "./node.rb"

module BinarySearchTree
    
    #Bin Tree Class
    class BinTree
        
        def initialize
            @root = nil
        end
        
        def insert(datum)
            if @root.nil?
                @root = Node.new(datum)
            else
                @root.insert(datum)
            end
        end
        
        def in_order(node=@root, &block)
            return if node.nil?
            
            in_order(node.left, &block)
            yield node
            in_order(node.right, &block)
        end
        
        def in_order(node=@root, &block)
            return if node.nil?
            in_order(node.left, &block)
            yield node
            in_order(node.right, &block)
        end
        
        def pre_order(node=@root, &block)
            return if node.nil?
            yield node
            in_order(node.left, &block)
            in_order(node.right, &block)
        end
        
        def post_order(node=@root, &block)
            return if node.nil?
            in_order(node.left, &block)
            in_order(node.right, &block)
            yield node
        end
        
        def search( datum, node=@root )
            return nil if node.nil?
            if datum < node.datum
                search( datum, node.left )
            elsif datum > node.datum
                search( datum, node.right )
            else
                return node
            end
        end
        
        def check_height(node)
            return 0 if node.nil?
            
            leftHeight = check_height(node.left)
            return -1 if leftHeight == -1
            
            rightHeight = check_height(node.right)
            return -1 if rightHeight == -1
            
            diff = leftHeight - rightHeight
            if diff.abs > 1
                -1
            else
                [leftHeight, rightHeight].max + 1
            end
        end
        
        def is_balanced?(node=@root)
            check_height(node) == -1 ? false : true
        end
        
    end
end
