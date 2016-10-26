#!/usr/bin/ruby -w

#Wrapper Module
module BinarySearchTree
    
    #Node Class
    class Node
    
        attr_reader :datum
        attr_accessor :left, :right
    
        #constructor Method    
        def initialize(nDatum)
            @datum = nDatum
        end
        
        def insert(nDatum)
            if nDatum <= @datum
                @left.nil? ? @left = Node.new(nDatum) : @left.insert(nDatum)
            elsif nDatum > @datum
                @right.nil? ? @right = Node.new(nDatum) : @right.insert(nDatum)
            end
        end
        
        def to_s
            @datum
        end
    end
end
