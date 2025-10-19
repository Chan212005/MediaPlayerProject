// src/refactored/strategy/HardwareRenderStrategy.java
package refactored.strategy;

public class HardwareRenderStrategy implements RenderStrategy {
    @Override
    public void render() {
        System.out.println("HardwareRenderStrategy: Using GPU acceleration");
        System.out.println("HardwareRenderStrategy: Offloading to hardware decoder");
        System.out.println("HardwareRenderStrategy: Rendering with hardware...");
    }
}