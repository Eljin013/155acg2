#version 430

layout (location=0) in vec3 position;

uniform mat4 axe_mv_matrix;
uniform mat4 axe_proj_matrix;

out vec4 color2;


void main(void)
{
	if (gl_VertexID == 0) {
		color2 = vec4(0.0, 0.0, 1.0, 1.0);
	}
	else if (gl_VertexID == 1) {
		color2 = vec4(0.0, 0.0, 1.0, 1.0);
	}
	else if (gl_VertexID == 2) {
		color2 = vec4(0.0, 1.0, 0.0, 1.0);
	}
	else if (gl_VertexID == 3) {
		color2 = vec4(0.0, 1.0, 0.0, 1.0);
	}
	else if (gl_VertexID == 4) {
		color2 = vec4(1.0, 0.0, 0.0, 1.0);
	}
	else if (gl_VertexID == 5) {
		color2 = vec4(1.0, 0.0, 0.0, 1.0);
	}

	gl_Position = axe_proj_matrix * axe_mv_matrix * vec4(position, 1.0);

} 