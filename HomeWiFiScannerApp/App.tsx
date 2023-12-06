import React, { useState, useEffect } from 'react';
import { View, Text, TextInput, Button, FlatList, TouchableOpacity, Modal, StyleSheet } from 'react-native';

const styles = StyleSheet.create({
    container: {
        flex: 1,
        padding: 16,
        justifyContent: 'center',
    },
    loginContainer: {
        marginBottom: 16,
    },
    input: {
        height: 40,
        borderColor: 'gray',
        borderWidth: 1,
        marginBottom: 8,
        paddingHorizontal: 8,
    },
    button: {
        marginBottom: 8,
    },
    flatlistItem: {
        paddingVertical: 8,
        borderBottomWidth: 1,
        borderBottomColor: 'lightgray',
    },
    modalContainer: {
        flex: 1,
        justifyContent: 'center',
        alignItems: 'center',
    },
    modalContent: {
        width: '80%',
        padding: 16,
        backgroundColor: 'white',
        borderRadius: 8,
        elevation: 5,
    },
});

const App = () => {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [jwtToken, setJwtToken] = useState('');
    const [arpList, setArpList] = useState([]);
    const [selectedArp, setSelectedArp] = useState(null);
    const [newName, setNewName] = useState('');
    const [isModalVisible, setModalVisible] = useState(false);
    const [isLoggedIn, setLoggedIn] = useState(false);

    useEffect(() => {
        if (jwtToken) {
            handleGetArpList();
            setLoggedIn(true);
        }
    }, [jwtToken]);

    const handleLogin = async () => {
        try {
            const response = await fetch('http://192.168.1.30:8080/user/login', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({ username, password }),
            });

            console.log('Login response status:', response.status);

            const data = await response.json();
            console.log('Login response data:', data);

            if (!response.ok) {
                throw new Error(`Login failed with status: ${response.status}`);
            }

            setJwtToken(data.token);
        } catch (error) {
            console.error('Error during login:', error.message);
        }
    };

    const handleGetArpList = async () => {
        try {
            const response = await fetch('http://192.168.1.30:8080/arp/getAll', {
                headers: {
                    Authorization: `Bearer ${jwtToken}`,
                },
            });

            const data = await response.json();
            setArpList(data);
        } catch (error) {
            console.error('Error fetching ARP list:', error);
        }
    };

    const handleRenameArp = async () => {
        try {
            if (selectedArp) {
                const response = await fetch('http://192.168.1.30:8080/arp/rename', {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json',
                        Authorization: `Bearer ${jwtToken}`,
                    },
                    body: JSON.stringify({ name: newName, mac: selectedArp.mac }),
                });

                setModalVisible(false);
                setSelectedArp(null);
                handleGetArpList();
            }
        } catch (error) {
            console.error('Error renaming ARP entry:', error);
        }
    };

    const handleRefresh = () => {
        handleGetArpList();
    };

    const renderItem = ({ item }) => (
        <TouchableOpacity
            onPress={() => {
                setSelectedArp(item);
                setModalVisible(true);
            }}
        >
            <View style={styles.flatlistItem}>
                <Text>{`Name: ${item.name}, IP: ${item.ip}, MAC: ${item.mac}`}</Text>
            </View>
        </TouchableOpacity>
    );

    return (
        <View style={styles.container}>
            {!isLoggedIn ? (
                <View style={styles.loginContainer}>
                    <Text>Login</Text>
                    <TextInput
                        style={styles.input}
                        placeholder="Username"
                        value={username}
                        onChangeText={text => setUsername(text)}
                    />
                    <TextInput
                        style={styles.input}
                        placeholder="Password"
                        secureTextEntry
                        value={password}
                        onChangeText={text => setPassword(text)}
                    />
                    <Button style={styles.button} title="Login" onPress={handleLogin} />
                </View>
            ) : (
                <>
                    <View style={{ flexDirection: 'row', justifyContent: 'space-between', alignItems: 'center', marginBottom: 16 }}>
                        <Text style={{ fontSize: 20, fontWeight: 'bold' }}>Uređaji na mreži</Text>
                        <Button title="Osveži" onPress={handleRefresh} />
                    </View>

                    <FlatList data={arpList} keyExtractor={item => item.mac} renderItem={renderItem} />

                    <Modal visible={isModalVisible} animationType="slide" transparent={true}>
                        <View style={styles.modalContainer}>
                            <View style={styles.modalContent}>
                                <TextInput
                                    style={styles.input}
                                    placeholder="Novo ime"
                                    value={newName}
                                    onChangeText={text => setNewName(text)}
                                />
                                <Button style={styles.button} title="Preimenuj" onPress={handleRenameArp} />
                                <Button title="Otkaži" onPress={() => setModalVisible(false)} />
                            </View>
                        </View>
                    </Modal>
                </>
            )}
        </View>
    );
};

export default App;
