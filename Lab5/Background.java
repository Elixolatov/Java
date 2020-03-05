public class Background implements Graph {
    private String color = "none";
    private String texture = "none";
    @Override public void draw() {
        System.out.println("color: " + color + "texture: " + texture);
    }
    public void setColor(String color) {
        this.color = color;
    }
    public void setTexture(String texture) {
        this.texture = texture;
    }
}