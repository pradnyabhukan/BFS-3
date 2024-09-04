class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Queue<Node> q = new LinkedList<>();
        HashMap<Node, Node> map = new HashMap<>();
        map.put(node, new Node(node.val));
        q.add(node);
        while(!q.isEmpty()) {
            Node temp = q.poll();
            List<Node> neighbors = temp.neighbors;
            for(int i=0 ; i<neighbors.size() ; i++) {
                Node neighbor = neighbors.get(i);
                if(!map.containsKey(neighbor)) {
                    map.put(neighbor, new Node(neighbor.val));
                    q.add(neighbor);
                }
                map.get(temp).neighbors.add(map.get(neighbor));
            }
        }
        return map.get(node);
    }
}
