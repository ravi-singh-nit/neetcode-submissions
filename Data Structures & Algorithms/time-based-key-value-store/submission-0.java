class TimeMap {
    Map<String,TreeMap<Integer,String>> cache;

    public TimeMap() {
        cache=new HashMap();
    }
    
    public void set(String key, String value, int timestamp) {
        cache.putIfAbsent(key,new TreeMap<>());
        cache.get(key).put(timestamp,value);
    }
    
    public String get(String key, int timestamp) {
        if(cache.containsKey(key)==false)
        return "";

        TreeMap<Integer,String> tmap=cache.get(key);
        Map.Entry<Integer,String> me= tmap.floorEntry(timestamp);
        return me==null ? "":me.getValue();
    }
}
