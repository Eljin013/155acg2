#version 430

out vec4 color;

uniform mat4 mv_matrix;
uniform mat4 proj_matrix;

in vec4 colorTwo;

void main(void)
{
	color = colorTwo;
}