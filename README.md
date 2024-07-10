# capacitor-plugin-example

Example

## Install

```bash
npm install capacitor-plugin-example
npx cap sync
```

## API

<docgen-index>

* [`echo(...)`](#echo)
* [`getOrientation()`](#getorientation)
* [`addListener('orientationChanged', ...)`](#addlistenerorientationchanged-)
* [Interfaces](#interfaces)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### echo(...)

```typescript
echo(options: options) => Promise<options>
```

| Param         | Type                                        |
| ------------- | ------------------------------------------- |
| **`options`** | <code><a href="#options">options</a></code> |

**Returns:** <code>Promise&lt;<a href="#options">options</a>&gt;</code>

--------------------


### getOrientation()

```typescript
getOrientation() => Promise<{ orientation: string; }>
```

**Returns:** <code>Promise&lt;{ orientation: string; }&gt;</code>

--------------------


### addListener('orientationChanged', ...)

```typescript
addListener(eventName: 'orientationChanged', listenerFunc: (info: { orientation: string; }) => void) => void
```

| Param              | Type                                                     |
| ------------------ | -------------------------------------------------------- |
| **`eventName`**    | <code>'orientationChanged'</code>                        |
| **`listenerFunc`** | <code>(info: { orientation: string; }) =&gt; void</code> |

--------------------


### Interfaces


#### options

| Prop        | Type                |
| ----------- | ------------------- |
| **`value`** | <code>string</code> |

</docgen-api>
