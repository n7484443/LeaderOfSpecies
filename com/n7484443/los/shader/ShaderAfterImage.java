package com.n7484443.los.shader;

public class ShaderAfterImage extends ShaderBase{
	private static final String COLOR_VERTEX_File = "src/com/n7484443/los/shader/vertShaderAfterImage.txt";
	private static final String COLOR_FRAGMENT_File = "src/org/FRD/shader/fragShaderAfterImage.txt";
	
	public ShaderAfterImage(){
		super(COLOR_VERTEX_File, COLOR_FRAGMENT_File);
	}

	protected void bindAttributes() {
		super.bindAttribute(0, "position");
		super.bindAttribute(1, "textureCoords");
	}
	
	protected void getAllUniformLocations() {
	}
}
