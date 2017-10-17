#version 430

layout (location=0) in vec3 position;

uniform mat4 obj_mv_matrix;
uniform mat4 obj_proj_matrix;

void main(void)
{
	gl_Position = obj_proj_matrix * obj_mv_matrix * vec4(position, 1.0);
} 