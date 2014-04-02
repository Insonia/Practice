package isA;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.io.Serializable;

public class DiagonalLayout implements LayoutManager,Serializable{
	private int gap = 10;
	
	private boolean majorDiagonal = true;
	
	private boolean lastFill = false;
	
	public DiagonalLayout(){
		
	}
	
	public DiagonalLayout(int gap, boolean major, boolean last){
		this.gap = gap;
		this.majorDiagonal = major;
		this.lastFill = last;
	}
	
	@Override
	public void addLayoutComponent(String name, Component comp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeLayoutComponent(Component comp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Dimension preferredLayoutSize(Container parent) {
		// TODO Auto-generated method stub
		return minimumLayoutSize(parent);
	}

	@Override
	public Dimension minimumLayoutSize(Container parent) {
		// TODO Auto-generated method stub
		return new Dimension(0, 0);
	}

	@Override
	public void layoutContainer(Container parent) {
		// TODO Auto-generated method stub
		int numberOfComponents = parent.getComponentCount();
		
		Insets insets = parent.getInsets();
		
		int w = parent.getSize().width - insets.left - insets.right;
		int h = parent.getSize().height - insets.bottom - insets.top;
		
		if(majorDiagonal){
			int x = 10, y = 10;
			
			for(int j = 0; j < numberOfComponents; j++){
				Component c= parent.getComponent(j);
				Dimension d = c.getPreferredSize();
				
				if(c.isVisible())
					if(lastFill && (j == numberOfComponents - 1))
						c.setBounds(x, y, w-x, h-y);
					else
						c.setBounds(x, y, d.width, d.height);
				
				x += d.height + gap;
				y += d.height + gap;
			}
		}else {
			int x = w - 10, y = 10;
			
			for(int j = 0; j < numberOfComponents; j++){
				Component c= parent.getComponent(j);
				Dimension d = c.getPreferredSize();
				
				if(c.isVisible())
					if(lastFill && (j == numberOfComponents - 1))
						c.setBounds(0, y, x, h-y);
					else
						c.setBounds(x-d.width, y, d.width, d.height);
				
				x -= (d.width + gap);
				y += d.height + gap;
			}
		}
	}

	public int getGap() {
		return gap;
	}

	public void setGap(int gap) {
		this.gap = gap;
	}

	public boolean isMajorDiagonal() {
		return majorDiagonal;
	}

	public void setMajorDiagonal(boolean majorDiagonal) {
		this.majorDiagonal = majorDiagonal;
	}

	public boolean isLastFill() {
		return lastFill;
	}

	public void setLastFill(boolean lastFill) {
		this.lastFill = lastFill;
	}

}
