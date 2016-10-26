#!/usr/bin/ruby -w

#Node Class
class Node
    
    attr_accessor :datum, :left, :right
    
    #constructor Method    
    def initialize(nDatum)
        @datum = nDatum
    end
    
    def to_s
        @datum
    end
end
