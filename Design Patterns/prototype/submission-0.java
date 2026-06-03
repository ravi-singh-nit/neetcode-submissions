interface Shape {
    Shape clone();
}

class Rectangle implements Shape,Cloneable {
    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    @Override
    public Shape clone() {
        // Write your code here
        try{
        return (Rectangle)super.clone();
        }catch(CloneNotSupportedException e){
            return null;
        }
    }
}

class Square implements Shape , Cloneable {
    private int length;

    public Square(int length) {
        this.length = length;
    }

    public int getLength() {
        return this.length;
    }

    @Override
    public Shape clone() {
       try{
        return (Square)super.clone();
        }catch(CloneNotSupportedException e){
            return null;
        }
    }
}

class Test {
    public List<Shape> cloneShapes(List<Shape> shapes) {
        // Write your code here
        List<Shape> ans=new ArrayList();
        for(Shape sh:shapes){
            ans.add(sh.clone());
        }
        return ans;
    }
}
