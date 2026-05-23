

class LFUCache {
    Map<Integer, DLLNode> cache;
    Map<Integer, DLinkedList> frequencyMap;
    int capacity;
    int currSize;
    int minFrequency;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        frequencyMap = new HashMap<>();
        currSize = 0;
        minFrequency = 0;
    }
    
    public int get(int key) {
        if (!cache.containsKey(key)) return -1;

        DLLNode curr = cache.get(key);
        update(curr);
        return curr.value;
    }

    public void update(DLLNode curr) {
        int currFreq = curr.freq;
        DLinkedList currll = frequencyMap.get(currFreq);
        currll.removeNode(curr);

        // FIXED: Agar minFrequency wali list khali ho gayi, to minFrequency badhao
        if (currFreq == minFrequency && currll.size == 0) {
            minFrequency++;
        }
        
        curr.freq++;

        DLinkedList newList = frequencyMap.getOrDefault(curr.freq, new DLinkedList());
        newList.addNode(curr);
        frequencyMap.put(curr.freq, newList);
    }
    
    public void put(int key, int value) {
        if (capacity == 0) return;

        if (cache.containsKey(key)) {
            DLLNode curr = cache.get(key);
            curr.value = value;
            update(curr);
        } else {
            if (currSize == capacity) {
                DLinkedList minFrequencyList = frequencyMap.get(minFrequency);
                // Least Recently Used node nikaalo min frequency list ke tail se
                DLLNode toRemove = minFrequencyList.tail.prev; 
                cache.remove(toRemove.key);
                minFrequencyList.removeNode(toRemove);
                currSize--;
            }

            // Naya node hamesha frequency 1 se shuru hota hai
            minFrequency = 1;
            DLLNode newNode = new DLLNode(key, value);
            newNode.freq = 1; // Explicitly set frequency to 1
            
            DLinkedList currList = frequencyMap.getOrDefault(1, new DLinkedList());
            currList.addNode(newNode);
            frequencyMap.put(1, currList);
            cache.put(key, newNode);
            currSize++; // FIXED: Naya node add karne par size badhaya
        }
    }
}

class DLLNode {
    int key;
    int value;
    int freq;
    DLLNode prev;
    DLLNode next;

    public DLLNode(int key, int value) {
        this.key = key;
        this.value = value;
        this.freq = 1; // Default frequency is 1
    }
}

class DLinkedList {
    DLLNode head;
    DLLNode tail;
    int size;

    public DLinkedList() {
        head = new DLLNode(-1, -1);
        tail = new DLLNode(-1, -1);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    // FIXED: Dummy head ke aage node secure tarike se insert karne ka logic
    public void addNode(DLLNode newNode) {
        DLLNode temp = head.next;
        newNode.next = temp;
        newNode.prev = head;
        head.next = newNode;
        temp.prev = newNode;
        size++;
    }

    public void removeNode(DLLNode node) {
        DLLNode prevNode = node.prev;
        DLLNode nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        size--;
    }
}