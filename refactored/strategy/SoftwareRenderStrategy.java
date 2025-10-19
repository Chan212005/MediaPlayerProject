// src/refactored/strategy/SoftwareRenderStrategy.java
package refactored.strategy;

public class SoftwareRenderStrategy implements RenderStrategy {
    public void render() {
        System.out.println("SoftwareRenderStrategy: Using CPU rendering");
        System.out.println("SoftwareRenderStrategy: Software decoding in progress");
        System.out.println("SoftwareRenderStrategy: Rendering with software...");
    }
}