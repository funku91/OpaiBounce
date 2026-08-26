#ifdef GL_ES
precision mediump float;
#endif

uniform vec2 iResolution;
uniform float iTime;

const float Pi = 3.14159;
const int complexity = 30;
const float fluid_speed = 18000.0;
const float color_intensity = 0.25;

void main()
{
    vec2 p = (2.0 * gl_FragCoord.xy - iResolution) / max(iResolution.x, iResolution.y);

    for(int i = 1; i < complexity; i++)
    {
        float phase = float(i) * 0.3;
        vec2 newp = p + iTime * 0.00035;
        newp.x += 0.6/float(i) * sin(float(i)*p.y + iTime/fluid_speed*(2000.0+float(i)) + phase) + 0.5;
        newp.y += 0.6/float(i) * cos(float(i)*p.x + iTime/fluid_speed*(1909.0+float(i)) + phase) - 0.5;
        p = newp;
    }

    vec3 col = vec3(
        0.0,  // 红色通道关闭
        clamp(color_intensity * sin(2.8*p.x) + 0.35, 0.0, 0.6),  // 青色通道
        clamp(color_intensity * sin(3.2*p.x + Pi/4.0) + 0.7, 0.5, 1.0)  // 蓝色通道
    );

    gl_FragColor = vec4(col * 1.1, 1.0);  // 确保输出闭合
}