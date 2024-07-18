import {Image, StyleSheet, Platform, ScrollView, View} from 'react-native';

import { HelloWave } from '@/components/HelloWave';
import ParallaxScrollView from '@/components/ParallaxScrollView';
import { ThemedText } from '@/components/ThemedText';
import { ThemedView } from '@/components/ThemedView';
import React, { useState, useEffect } from 'react';
import axios from 'axios';
import {Button, Card, Icon, Text} from "@rneui/themed";
import Block from "@/components/Block";


export default function HomeScreen() {
    const API_URL = 'http://localhost/api/api/funeralServices';

    const [data, setData] = useState([]);

    useEffect(() => {
        fetchData();
    }, []);

    const fetchData = async () => {
        try {
            const response = await axios.get(API_URL);
            setData(response.data);
        } catch (error) {
            console.error('Error fetching data:', error);
        }
    };

  return (
    <ParallaxScrollView
      headerBackgroundColor={{ light: '#A1CEDC', dark: '#1D3D47' }}
      headerImage={
        <Image
          source={require('@/assets/images/urn.jpeg')}
          style={styles.reactLogo}
        />
      }>
     



                  <View style={styles.app}>
                      <ThemedText type="title">Szolgáltatások</ThemedText>

                      <div className="grid grid-cols-2">
                          {data.map((funeral) => {
                              return (
                                  <div key={funeral.name} style={styles.row}>
                                      <Card key={funeral.name} >
                                          <Card.Title>{funeral.name}</Card.Title>
                                          <Card.Divider />
                                          <Card.Image
                                              style={{ padding: 0 }}
                                              source={{
                                                  uri:
                                                      'https://awildgeographer.files.wordpress.com/2015/02/john_muir_glacier.jpg',
                                              }}
                                          />
                                          <Text style={{ marginBottom: 10 }}>
                                              {funeral.description}
                                          </Text>
                                          <Button
                                              icon={
                                                  <Icon
                                                      name="code"
                                                      color="#ffffff"
                                                      iconStyle={{ marginRight: 10 }}
                                                  />
                                              }
                                              buttonStyle={{
                                                  borderRadius: 0,
                                                  marginLeft: 0,
                                                  marginRight: 0,
                                                  marginBottom: 0,
                                              }}
                                              title="VIEW NOW"
                                          />
                                      </Card>
                                  </div>

                              );
                          })}

                      </div>



                  </View>


      <ThemedView style={styles.stepContainer}>
        <ThemedText type="subtitle">Step 1: Try it</ThemedText>
        <ThemedText>
          Edit <ThemedText type="defaultSemiBold">app/(tabs)/index.tsx</ThemedText> to see changes.
          Press{' '}
          <ThemedText type="defaultSemiBold">
            {Platform.select({ ios: 'cmd + d', android: 'cmd + m' })}
          </ThemedText>{' '}
          to open developer tools.
        </ThemedText>
      </ThemedView>
      <ThemedView style={styles.stepContainer}>
        <ThemedText type="subtitle">Step 2: Explore</ThemedText>
        <ThemedText>
          Tap the Explore tab to learn more about what's included in this starter app.
        </ThemedText>
      </ThemedView>
      <ThemedView style={styles.stepContainer}>
        <ThemedText type="subtitle">Step 3: Get a fresh start</ThemedText>
        <ThemedText>
          When you're ready, run{' '}
          <ThemedText type="defaultSemiBold">npm run reset-project</ThemedText> to get a fresh{' '}
          <ThemedText type="defaultSemiBold">app</ThemedText> directory. This will move the current{' '}
          <ThemedText type="defaultSemiBold">app</ThemedText> to{' '}
          <ThemedText type="defaultSemiBold">app-example</ThemedText>.
        </ThemedText>

      </ThemedView>

    </ParallaxScrollView>
  );
}

const styles = StyleSheet.create({
  titleContainer: {
    alignItems: 'center',
    gap: 8,
  },
  stepContainer: {
    gap: 8,
    marginBottom: 8,
  },
  reactLogo: {
    height: "100%",
    width: "100%",

  },
    app: {
        flex: 4, // the number of columns you want to devide the screen into
        marginHorizontal: "auto",
        width: "100%",
        margin: "auto",
    },
    row: {
        flexDirection: "row",
        width: "400px",
        flex: 4
    },
    "1col":  {
        backgroundColor:  "lightblue",
        borderColor:  "#fff",
        borderWidth:  1,
        flex:  1
    },
    "2col":  {
        backgroundColor:  "green",
        borderColor:  "#fff",
        borderWidth:  1,
        flex:  2
    },
    "3col":  {
        backgroundColor:  "orange",
        borderColor:  "#fff",
        borderWidth:  1,
        flex:  3
    },
    "4col":  {
        flex:  4
    },
    container: {
        flex: 1,
    },

    fonts: {
        marginBottom: 8,
    },
    user: {
        flexDirection: 'row',
        marginBottom: 6,
    },
    image: {
        width: 30,
        height: 30,
        marginRight: 10,
    },
    name: {
        fontSize: 16,
        marginTop: 5,
    }
});
