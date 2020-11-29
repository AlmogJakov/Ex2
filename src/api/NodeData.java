package api;

/** not sure it's in this class */
/////////////////////////////////////////
//////////////// Node class /////////////
/////////////////////////////////////////
public class NodeData implements node_data{
    // This class should be accessible from outside
    // (the reason is because we initialize a vertex before adding it to the graph)
    // and hence this class is public
    private static int keys = 0;
    private int _key, _tag;
    private double _weight;
    private String _info;
    private geo_location _location;

    public NodeData(){
        _key = keys++;
        _location = new GeoLocation();
        _weight = 0;
        _tag = 0;
        _info = "";
    }

    public NodeData(int key,geo_location location){
    	this();
        _key = key;
        if (location==null) return;
        _location = location;
    }
    
    public NodeData(int key, int tag, double weight, String info ,geo_location location){
        _key = key;
        _tag = tag;
        _weight = weight;
        if (info==null) _info = new String();
        else _info = info;
        if (location==null) _location = new GeoLocation();
        else _location = location;
    }
    
    /* Copy Constructor */
	/* This constructor is mainly used by deep copy methods */
    public NodeData(NodeData n){
    	this();
    	if (n==null) return;
        _key = n.getKey();
        _location = new GeoLocation(n.getLocation());
        _weight = n._weight;
        _tag = n._tag;
        _info = new String(n._info);
    }

    @Override
    public int getKey() {
        return _key;
    }

    @Override
    public geo_location getLocation() {
        return _location;
    }

    @Override
    public void setLocation(geo_location p) {
    	if (p==null) this._location = new GeoLocation();
    	else this._location = p;
    }

    @Override
    public double getWeight() {
        return _weight;
    }

    @Override
    public void setWeight(double w) {
    	this._weight = w;
    }

    @Override
    public String getInfo() {
        return _info;
    }

    @Override
    public void setInfo(String s) {
    	if (s==null) this._info = new String();
    	else this._info = s;
    }

    @Override
    public int getTag() {
        return _tag;
    }

    @Override
    public void setTag(int t) {
        _tag = t;
    }
    
    @Override
	public boolean equals(Object n) {
    	if (n == this) { return true; } 
		if (n instanceof NodeData) {return this.equals((NodeData) n);} 
		return false;
	}

	public boolean equals(NodeData n) {
		if (this.getKey()==n.getKey()&&this.getTag()==n.getTag()&&this.getWeight()==n.getWeight()
				&&this.getInfo().equals(n.getInfo())&&this._location.equals(n.getLocation()))
			return true;
		return false;
	}
}