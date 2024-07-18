import React from 'react'
import { StyleSheet, View } from 'react-native'

const Block = ({
                   children,
                   style,
                   flex = 1,
                   row, // <-- add this
                   ...props
               }) => {
    const blockStyle = StyleSheet.flatten([
        flex !== undefined && { flex },
        row && { flexDirection: 'row' }, // <-- add this
        style,
    ])

    return (
        <View style={blockStyle} {...props}>
            {children}
        </View>
    )
}

export default Block
