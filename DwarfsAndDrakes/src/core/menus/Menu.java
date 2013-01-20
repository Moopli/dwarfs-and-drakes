/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package core.menus;

import core.graphics.*;
import java.util.LinkedList;

/**
 * A Menu is a container class -- replicating much of the functionality of a 
 * system like swing, it consists of a fusion between TextSurfaces for layout 
 * and interaction functionality. Menus Are either active or inactive -- active 
 * menus are rendered, inactive menus are not. Active menus respond to mouse 
 * input, inactive menus do not.
 * @author filip
 */
public class Menu extends InterfaceObject {
    
    
    public boolean isActive;
    
    public LinkedList<InterfaceObject> children = new LinkedList<InterfaceObject>();
    
    
    public Menu(int w, int h, int x, int y, InterfaceObject parent){
        super(w, h, x, y, parent);
        
        
    }
    
    @Override
    public void onHover(int mouseX, int mouseY){
        if (this.isActive && (hovering = this.isHovering(mouseX, mouseY))) {
            for (InterfaceObject child : children){
                child.onHover(mouseX - this.graphics.x, mouseY - this.graphics.y);
            }
        }
    }
    
    @Override
    public void onClick(){
        if (hovering && this.isActive) {
            for (InterfaceObject child : children){
                child.onClick();
            }
        }
    }
    
    @Override
    public void updateGraphics(){
        for (InterfaceObject child: children){
            child.updateGraphics();
            
        }
        
    }
}
