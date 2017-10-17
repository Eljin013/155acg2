#version 430

out vec4 color;

uniform mat4 axe_mv_matrix;
uniform mat4 axe_proj_matrix;

in vec4 color2;

void main(void)
{
	color = color2;
}