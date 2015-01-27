# noise
Perlin noise function generator

Most implementations of the perlin noise algorithm are bounded by width and height. This one however is not. The generator returns an object representation of the 
perlin noise function f:R^2 -> [-1,1]. 

In theory the noise function is unbounded. However, the randomly generated gradients for a given gridpoint must be the same with every lookup and are stored in memory. Therefore the noise function is only bounded by memory.

So far the noise function only supports 2 dimensions

## usage

### generating a noise function
```java
PerlinNoiseGenerator generator = new PerlinNoiseGenerator(); 
Noise noise1 = generator.generate();
Noise noise2 = generator.generate();
Noise noise3 = generator.generate();
```
### noise value at a coordinate
```java
float noiseValue = noise1.get(20.5f,31.2f);
```
#### Clouds
The cloud is a convergent series. The second parameter in the Cloud constructor denotes the amount of terms "n".
```java
Noise perlinNoise = generator.generate();
Noise cloud = new Cloud(perlinNoise,5);
```
![Compound 1](https://github.com/sonsyphon/noise/blob/master/docs/compound2.png)

### Function composition
The cloud is a particular function composition. It is possible to build your own compositions. To remain consistent with the code you can implement to the Noise interface.
```java
final Noise perlinNoise = generator.generate();

Noise compoundNoise = new Noise() {
  @Override
  public float get(float x, float y) {
    return
      Math.abs(perlinNoise.get(x,y)) +
      Math.abs(1/2f*perlinNoise.get(x/2f, y/2f)) +
      Math.abs(1/4f*perlinNoise.get(x/4f, y/4f)) +
      Math.abs(1/8f*perlinNoise.get(x/8f, y/8f));
  }
};
```
![Compound 1](https://github.com/sonsyphon/noise/blob/master/docs/compound1.png)

