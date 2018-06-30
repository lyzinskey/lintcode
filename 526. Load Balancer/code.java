//Implement a load balancer for web servers. It provide the following functionality:

//Add a new server to the cluster => add(server_id).
//Remove a bad server from the cluster => remove(server_id).
//Pick a server in the cluster randomly with equal probability => pick().

//Example
//At beginning, the cluster is empty => {}.
//
//  add(1)
//  add(2)
//  add(3)
//  pick()
//  >> 1         // the return value is random, it can be either 1, 2, or 3.
//  pick()
//  >> 2
//  pick()
//  >> 1
//  pick()
//  >> 3
//  remove(1)
//  pick()
//  >> 2
//  pick()
//  >> 3
//  pick()
//  >> 3




public class LoadBalancer {
    
    private Map<Integer, Integer> hashmap;
    private List<Integer> list;
    private Random rand;
    
    public LoadBalancer() {
        this.hashmap = new HashMap<>();
        this.list = new ArrayList<>();
        this.rand = new Random();
    }

    /*
     * @param server_id: add a new server to the cluster
     * @return: nothing
     */
    public void add(int server_id) {
        if (hashmap.containsKey(server_id)) {
            return;
        }
        
        hashmap.put(server_id, list.size());
        list.add(server_id);
    }

    /*
     * @param server_id: server_id remove a bad server from the cluster
     * @return: nothing
     */
    public void remove(int server_id) {
        if (!hashmap.containsKey(server_id)) {
            return;
        }
        
        int index = hashmap.get(server_id);
        
        if (index < list.size() - 1) {
            int lastServer = list.get(list.size() - 1);
            list.set(index, lastServer);
            hashmap.put(lastServer, index);
        }
        
        list.remove(list.size() - 1);
        hashmap.remove(server_id);
    }

    /*
     * @return: pick a server in the cluster randomly with equal probability
     */
    public int pick() {
        return list.get(rand.nextInt(list.size()));
    }
}


